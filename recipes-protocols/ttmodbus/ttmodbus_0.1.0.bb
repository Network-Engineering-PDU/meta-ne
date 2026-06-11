# -*- mode: Conf; -*-
SUMMARY = "Tychetools Modbus server"
LICENSE = "CLOSED"

RDEPENDS_${PN} += "bash"
inherit autotools pkgconfig update-rc.d

SRCBRANCH = "master"
SRCREV = "603832d6d3ee77de79f542f776215de4f340c85f"
SRC_URI = "git://bitbucket.org/tychetools/modbus_server.git;protocol=ssh;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

DEPENDS += "cjson curl libmodbus"

FILES_${PN} += " \
    ${bindir}/modbus_server \
"

FILES_${PN}-dbg += " \
    ${bindir}/.debug \
"

do_install_append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 755 ${S}/scripts/init ${D}${sysconfdir}/init.d/modbus_server
}

PACKAGES = "${PN} ${PN}-dbg"
INITSCRIPT_NAME = "modbus_server"
INITSCRIPT_PARAMS = "stop 60 0 1 6 ."
