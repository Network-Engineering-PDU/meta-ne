# -*- mode: Conf; -*-
SUMMARY = "Configuration of Heimdall's GPIO at startup"
LICENSE = "CLOSED"

RDEPENDS_${PN} += "bash"
inherit update-rc.d

SRC_URI += " \
	file://gpioinit.sh \
"

do_install() {
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/gpioinit.sh ${D}${sysconfdir}/init.d/gpioinit.sh
}

PACKAGES = "${PN}"
INITSCRIPT_NAME = "gpioinit.sh"
INITSCRIPT_PARAMS = "start 01 5 ."
