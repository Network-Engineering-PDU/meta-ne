# -*- mode: Conf; -*-
SUMMARY = "Tychetools autossh tunnel service"
LICENSE = "CLOSED"

inherit update-rc.d

RDEPENDS_${PN} += "bash"

SRCBRANCH = "master"
SRCREV = "9227f5c9eb4df6668936fffbf84ad6badab2155e"
SRC_URI = "git://bitbucket.org/tychetools/heimdall.git;protocol=ssh;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${bindir}
	install -m 755 autossh/autossh.sh ${D}${bindir}

    install -d ${D}${sysconfdir}/init.d
	install -m 755 autossh/ssh_tunnel ${D}${sysconfdir}/init.d
}

FILES_${PN} += " \
	${sysconfdir}/init.d/ssh_tunnel \
	"

PACKAGES = "${PN}"

INITSCRIPT_NAME = "ssh_tunnel"
INITSCRIPT_PARAMS = "defaults 70"
