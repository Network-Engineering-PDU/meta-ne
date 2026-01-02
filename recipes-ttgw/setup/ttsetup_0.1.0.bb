# -*- mode: Conf; -*-
SUMMARY = "Network-Engineering-PDU heimdall configuration script"
LICENSE = "CLOSED"

RDEPENDS_${PN} += "bash"
inherit update-rc.d

SRCBRANCH = "main"
SRCREV = "901ba2cdb7e25b5c9756e0f56f8490557fdd9c3b"
SRC_URI = "git://github.com/Network-Engineering-PDU/heimdall.git;protocol=https;branch=${SRCBRANCH}"

SRC_URI += " \
	file://autottsetup.sh \
"

S = "${WORKDIR}/git/ttsetup"

do_compile() {
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
