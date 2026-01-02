# -*- mode: Conf; -*-
SUMMARY = "Network-Engineering-PDU autossh tunnel service"
LICENSE = "CLOSED"

inherit update-rc.d

RDEPENDS_${PN} += "bash"

SRCBRANCH = "main"
SRCREV = "901ba2cdb7e25b5c9756e0f56f8490557fdd9c3b"
SRC_URI = "git://github.com/Network-Engineering-PDU/heimdall.git;protocol=https;branch=${SRCBRANCH}"

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
