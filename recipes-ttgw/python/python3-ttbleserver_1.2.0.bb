# -*- mode: Conf; -*-
SUMMARY = "Network-Engineering-PDU Bluetooth configuration server application"
HOMEPAGE = "https://github.com/Network-Engineering-PDU/ble_config_server/"
LICENSE = "CLOSED"

SRCBRANCH = "main"
SRCREV = "db625fee8cc2ebbc897260862a5a6a3b4d298253"
SRC_URI = "git://github.com/Network-Engineering-PDU/ble_config_server.git;protocol=https;branch=${SRCBRANCH}"

SRC_URI += " \
	file://init \
	file://ble_config_key.pub \
"

S = "${WORKDIR}/git"

inherit setuptools3 update-rc.d

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

RDEPENDS_${PN} = "\
	${PYTHON_PN}-dbus-next \
	${PYTHON_PN}-cffi \
"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/ttbleserver
	install -m 655 ${WORKDIR}/ble_config_key.pub ${D}${sysconfdir}/ble_config_key.pub
}

BBCLASSEXTEND = "native nativesdk"

INITSCRIPT_NAME = "ttbleserver"
INITSCRIPT_PARAMS = "start 80 2 3 4 5 . stop 20 0 1 6 ."
