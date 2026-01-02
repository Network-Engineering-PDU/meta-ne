# -*- mode: Conf; -*-
SUMMARY = "Network-Engineering-PDU raft library"
HOMEPAGE = "https://github.com/Network-Engineering-PDU/raft/"
LICENSE = "CLOSED"

SRCBRANCH = "devel"
SRCREV = "edc24787861c50d5491025d574fd9bf3278e0092"
SRC_URI = "git://github.com/Network-Engineering-PDU/raft.git;protocol=https;branch=${SRCBRANCH}"

SRC_URI += " \
	file://fix_setup.patch \
"

S = "${WORKDIR}/git"

inherit setuptools3

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-msgpack \
"

BBCLASSEXTEND = "native nativesdk"
