# -*- mode: Conf; -*-
SUMMARY = "Network-Engineering-PDU autorun"
LICENSE = "CLOSED"

RDEPENDS_${PN} += "bash"

SRCBRANCH = "main"
SRCREV = "1a35492a144d172e24c8f4b279588d039fa35775"
SRC_URI = "git://github.com/Network-Engineering-PDU/usb_autorun.git;protocol=https;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

SRC_URI += "\
    file://public.pem \
"

FILES_${PN} += " \
    ${bindir}/usb_autorun.sh \
    ${bindir}/usb_mount.sh \
    ${bindir}/firmware_update_wrapper.sh \
    ${sysconfigdir}/udev/rules.d/99-usb-autorun.rules \
    ${datadir}/usb_autorun/public.pem \
"

do_install_append() {
    install -d ${D}${bindir}
    install -d ${D}${datadir}/usb_autorun
    install -d ${D}${sysconfdir}/udev/rules.d

    install -m 755 ${S}/usb_autorun.sh ${D}${bindir}/usb_autorun.sh
    install -m 755 ${S}/usb_mount.sh ${D}${bindir}/usb_mount.sh
    install -m 755 ${S}/firmware_update_wrapper.sh ${D}${bindir}/firmware_update_wrapper.sh
    install -m 644 ${S}/99-usb-autorun.rules ${D}${sysconfdir}/udev/rules.d/99-usb-autorun.rules
    install -m 755 ${WORKDIR}/public.pem ${D}${datadir}/usb_autorun/public.pem
}

PACKAGES = "${PN}"
