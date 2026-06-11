# -*- mode: Conf; -*-
SUMMARY = "Network-Engineering-PDU SNMP utilities"
HOMEPAGE = "https://github.com/Network-Engineering-PDU/snmp-client/"
LICENSE = "CLOSED"

SRCBRANCH = "main"
SRCREV = "a8fefd4a8d0d6f10f6d3a263905be55bbeac98e9"
SRC_URI = "git://github.com/Network-Engineering-PDU/snmp-client.git;protocol=https;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

inherit setuptools3

do_configure_append() {
	sed -e 's@/path/to/executable/ttsnmpd_helper@/usr/bin/ttsnmpd_helper@' \
	-i ${WORKDIR}/git/snmpd.conf
	cp ${WORKDIR}/git/snmpd.conf ${WORKDIR}/snmpd.conf

	sed -e 's@/path/to/executable/nesnmpd_helper@/usr/bin/nesnmpd_helper@' \
	-i ${WORKDIR}/git/ne_snmpd.conf
	cp ${WORKDIR}/git/ne_snmpd.conf ${WORKDIR}/ne_snmpd.conf
}

do_install_append () {
    install -d ${D}${datadir}/ttsnmp
	install -m 644 ${WORKDIR}/snmpd.conf ${D}${datadir}/ttsnmp/snmpd.conf
	install -m 644 ${WORKDIR}/ne_snmpd.conf ${D}${datadir}/ttsnmp/ne_snmpd.conf
}

FILES_${PN} += " \
    ${datadir}/ttsnmp/snmpd.conf \
"

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

BBCLASSEXTEND = "native nativesdk"

