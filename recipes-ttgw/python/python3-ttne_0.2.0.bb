# -*- mode: Conf; -*-
SUMMARY = "Network-Engineering-PDU NE API"
HOMEPAGE = "https://github.com/Network-Engineering-PDU/ne-fw-api/"
LICENSE = "CLOSED"

SRCBRANCH = "main"
SRCREV = "c8579086b5b15fb5330cf08fccd7b17c05793491"
SRC_URI = "git://github.com/Network-Engineering-PDU/ne-fw-api.git;protocol=https;branch=${SRCBRANCH}"

SRC_URI += " \
	file://init \
"

S = "${WORKDIR}/git"

inherit setuptools3 update-rc.d

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-requests \
    ${PYTHON_PN}-fastapi \
    ${PYTHON_PN}-uvicorn \
    ${PYTHON_PN}-uvloop \
    ${PYTHON_PN}-python-multipart \
    fw-om \
    fw-pmb \
"

do_install_append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/ttne
}

BBCLASSEXTEND = "native nativesdk"

INITSCRIPT_NAME = "ttne"
INITSCRIPT_PARAMS = "defaults 75"
