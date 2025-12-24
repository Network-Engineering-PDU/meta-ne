# -*- mode: Conf; -*-
SUMMARY = "Tychetools raft library"
HOMEPAGE = "https://bitbucket.org/tychetools/raft/"
LICENSE = "CLOSED"

SRCBRANCH = "devel"
SRCREV = "b90beead4552d1b153ba588f9a82ff2c2ed9ad32"
SRC_URI = "git://bitbucket.org/tychetools/raft.git;protocol=ssh;branch=${SRCBRANCH}"

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
