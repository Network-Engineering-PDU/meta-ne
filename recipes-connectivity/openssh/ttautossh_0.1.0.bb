# -*- mode: Conf; -*-
SUMMARY = "Network-Engineering-PDU autossh tunnel service"
LICENSE = "CLOSED"

inherit update-rc.d

RDEPENDS_${PN} += "bash"

SRCBRANCH = "main"
SRCREV = "19a34a2c027febe0342c8e01d07c9dd4a9eaaf15"
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
