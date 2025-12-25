# -*- mode: Conf; -*-
SUMMARY = "Tychetools heimdall configuration script"
LICENSE = "CLOSED"

RDEPENDS_${PN} += "bash"
inherit update-rc.d

SRCBRANCH = "master"
SRCREV = "7661a5dca6562b96592d3559b963f1917c7d5584"
SRC_URI = "git://bitbucket.org/tychetools/heimdall.git;protocol=ssh;branch=${SRCBRANCH}"

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
