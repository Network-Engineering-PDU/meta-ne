# -*- mode: Conf; -*-
SUMMARY = "Network-Engineering-PDU heimdall configuration script"
LICENSE = "CLOSED"

RDEPENDS_${PN} += "bash"
inherit update-rc.d

SRCBRANCH = "main"
SRCREV = "19a34a2c027febe0342c8e01d07c9dd4a9eaaf15"
SRC_URI = "git://github.com/Network-Engineering-PDU/heimdall.git;protocol=https;branch=${SRCBRANCH}"

SRC_URI += " \
	file://autottsetup.sh \
"

S = "${WORKDIR}/git/ttsetup"

do_compile() {
	chmod +x ${S}/archive_ttsetup.sh
	./archive_ttsetup.sh
}

do_install() {
	install -d ${D}${bindir}
	install -m 755 ttsetup.sh ${D}${bindir}

	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/autottsetup.sh ${D}${sysconfdir}/init.d/autottsetup.sh
}

PACKAGES = "${PN}"
INITSCRIPT_NAME = "autottsetup.sh"
INITSCRIPT_PARAMS = "start 02 5 ."
