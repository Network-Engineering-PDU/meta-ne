# -*- mode: Conf; -*-
SUMMARY = "Tychetools SNMP utilities"
HOMEPAGE = "https://bitbucket.org/tychetools/snmp-client/"
LICENSE = "CLOSED"

SRCBRANCH = "master"
SRCREV = "302de7bce5b1674788f7b9113ca32f3df3309afa"
SRC_URI = "git://bitbucket.org/tychetools/snmp-client.git;protocol=ssh;branch=${SRCBRANCH}"

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

