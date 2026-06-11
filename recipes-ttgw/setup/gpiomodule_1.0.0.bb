# -*- mode: Conf; -*-
SUMMARY = "Network-Engineering-PDU gpio module"
LICENSE = "CLOSED"

RDEPENDS_${PN} += "bash"
inherit autotools pkgconfig update-rc.d

SRCBRANCH = "main"
SRCREV = "ae25493ddac4df6e1caeeb20bb704153a0ad1317"
SRC_URI = "git://github.com/Network-Engineering-PDU/gpio_module.git;protocol=https;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

DEPENDS += "cjson libgpiod"

FILES_${PN} += " \
    ${bindir}/gpio_module \
    ${datadir}/gpio_module \
"

FILES_${PN}-dbg += " \
    ${bindir}/.debug \
"

do_install_append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 755 ${S}/scripts/init ${D}${sysconfdir}/init.d/gpio_module
}

PACKAGES = "${PN} ${PN}-dbg"
INITSCRIPT_NAME = "gpio_module"
INITSCRIPT_PARAMS = "defaults 20"
