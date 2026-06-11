# -*- mode: Conf; -*-
SUMMARY = "TycheTools NE API"
HOMEPAGE = "https://bitbucket.org/tychetools/ne-fw-api/"
LICENSE = "CLOSED"

SRCBRANCH = "master"
SRCREV = "d88a802c11cadacd26d2fa890bbe2d2c27f107c7"
SRC_URI = "git://bitbucket.org/tychetools/ne-fw-api.git;protocol=ssh;branch=${SRCBRANCH}"

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
