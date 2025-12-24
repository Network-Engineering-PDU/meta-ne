SUMMARY = "Python interface for the SEGGER J-Link."
HOMEPAGE = "https://github.com/Square/pylink"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=834c4b2cb72db13143b58bebff15bafb"

SRC_URI = "git://github.com/square/pylink.git;branch=master;protocol=https"
SRCREV ?= "968fa37b11e1eb6918a067d888efc5a35c60064e"

inherit setuptools3

S = "${WORKDIR}/git"

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"
DEPENDS = "${PYTHON_PN}-six-native"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-future \
    ${PYTHON_PN}-psutil \
"

BBCLASSEXTEND = "native nativesdk"
