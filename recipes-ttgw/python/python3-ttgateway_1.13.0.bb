# -*- mode: Conf; -*-
SUMMARY = "Network-Engineering-PDU gateway application"
HOMEPAGE = "https://github.com/Network-Engineering-PDU/gw-app/"
LICENSE = "CLOSED"

SRCBRANCH = "devel"
SRCREV = "884dc407b6e6b151b70e35939caf9c094616e79a"
SRC_URI = "git://github.com/Network-Engineering-PDU/gw-app.git;protocol=https;branch=${SRCBRANCH}"

SRC_URI += " \
	file://init \
	file://ca.crt \
	file://client.crt \
	file://client.key \
	file://server.crt \
	file://server.key \
"

S = "${WORKDIR}/git"

inherit setuptools3 update-rc.d

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-cmd2 \
    ${PYTHON_PN}-requests \
    ${PYTHON_PN}-websockets \
    ${PYTHON_PN}-ttgwlib \
    ${PYTHON_PN}-ttraft \
    ${PYTHON_PN}-netsnmp \
    ${PYTHON_PN}-noise \
    ${PYTHON_PN}-python-multipart \
    openocd \
    net-snmp \
"

do_install_append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/ttgateway

	install -d ${D}${sysconfdir}/Network-Engineering-PDU
	install -d ${D}${sysconfdir}/Network-Engineering-PDU/certs
	install -m 600 ${WORKDIR}/ca.crt ${D}${sysconfdir}/Network-Engineering-PDU/certs/ca.crt
	install -m 600 ${WORKDIR}/client.crt ${D}${sysconfdir}/Network-Engineering-PDU/certs/client.crt
	install -m 600 ${WORKDIR}/client.key ${D}${sysconfdir}/Network-Engineering-PDU/certs/client.key
	install -m 600 ${WORKDIR}/server.crt ${D}${sysconfdir}/Network-Engineering-PDU/certs/server.crt
	install -m 600 ${WORKDIR}/server.key ${D}${sysconfdir}/Network-Engineering-PDU/certs/server.key
}

BBCLASSEXTEND = "native nativesdk"

INITSCRIPT_NAME = "ttgateway"
INITSCRIPT_PARAMS = "defaults 75"
