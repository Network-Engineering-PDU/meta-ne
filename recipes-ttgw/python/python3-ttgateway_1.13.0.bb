# -*- mode: Conf; -*-
SUMMARY = "Tychetools gateway application"
HOMEPAGE = "https://bitbucket.org/tychetools/gw-app/"
LICENSE = "CLOSED"

SRCBRANCH = "devel"
SRCREV = "109fca0ec42a774ada0e9c234f8ac744ebb93b5d"
SRC_URI = "git://bitbucket.org/tychetools/gw-app.git;protocol=ssh;branch=${SRCBRANCH}"

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

	install -d ${D}${sysconfdir}/tychetools
	install -d ${D}${sysconfdir}/tychetools/certs
	install -m 600 ${WORKDIR}/ca.crt ${D}${sysconfdir}/tychetools/certs/ca.crt
	install -m 600 ${WORKDIR}/client.crt ${D}${sysconfdir}/tychetools/certs/client.crt
	install -m 600 ${WORKDIR}/client.key ${D}${sysconfdir}/tychetools/certs/client.key
	install -m 600 ${WORKDIR}/server.crt ${D}${sysconfdir}/tychetools/certs/server.crt
	install -m 600 ${WORKDIR}/server.key ${D}${sysconfdir}/tychetools/certs/server.key
}

BBCLASSEXTEND = "native nativesdk"

INITSCRIPT_NAME = "ttgateway"
INITSCRIPT_PARAMS = "defaults 75"
