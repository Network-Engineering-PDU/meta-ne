# -*- mode: Conf; -*-
SUMMARY = "Network-Engineering-PDU Modbus server"
LICENSE = "CLOSED"

RDEPENDS_${PN} += "bash"
inherit autotools pkgconfig update-rc.d

SRCBRANCH = "main"
SRCREV = "dd666f587adb8434ca66dfc3d3ba537f7ee21f20"
SRC_URI = "https://github.com/Network-Engineering-PDU/modbus_server.git;branch=${SRCBRANCH}"

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
