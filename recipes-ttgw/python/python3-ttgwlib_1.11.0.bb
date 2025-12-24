# -*- mode: Conf; -*-
SUMMARY = "Tychetools gateway library"
HOMEPAGE = "https://bitbucket.org/tychetools/gw-library/"
LICENSE = "CLOSED"

SRCBRANCH = "devel"
SRCREV = "2c442d9d48bb09ee87672b471b5b03265aa2aa19"
SRC_URI = "git://bitbucket.org/tychetools/gw-library.git;protocol=ssh;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

inherit setuptools3

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-pyserial \
    ${PYTHON_PN}-cryptography \
    ${PYTHON_PN}-pylink \
    ${PYTHON_PN}-boto3 \
    ${PYTHON_PN}-packaging \
"

BBCLASSEXTEND = "native nativesdk"
