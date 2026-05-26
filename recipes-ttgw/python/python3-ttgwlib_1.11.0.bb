# -*- mode: Conf; -*-
SUMMARY = "Network-Engineering-PDU gateway library"
HOMEPAGE = "https://github.com/Network-Engineering-PDU/gw-library/"
LICENSE = "CLOSED"

SRCBRANCH = "devel"
SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/Network-Engineering-PDU/gw-library.git;protocol=https;branch=${SRCBRANCH}"

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
