# -*- mode: Conf; -*-
SUMMARY = "Network-Engineering-PDU NE API"
HOMEPAGE = "https://github.com/Network-Engineering-PDU/ne-fw-api/"
LICENSE = "CLOSED"

SRCBRANCH = "main"
SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/Network-Engineering-PDU/ne-fw-api.git;protocol=https;branch=${SRCBRANCH}"

SRC_URI += " \
	file://init \
	file://persist-bluetooth-power-state.patch \
	file://ttne-ota.service \
	file://ttne-ota-health.service \
	file://ttne-ota-health-boot.service \
"

S = "${WORKDIR}/git"

# If the git checkout in ${WORKDIR}/git lacks a valid HEAD, the reproducible
# build helper may fail when attempting to derive SOURCE_DATE_EPOCH from git.
# Use a fixed SOURCE_DATE_EPOCH as a safe fallback for this recipe.
SOURCE_DATE_EPOCH = "0"

inherit setuptools3 update-rc.d systemd

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-requests \
    ${PYTHON_PN}-fastapi \
    ${PYTHON_PN}-uvicorn \
    ${PYTHON_PN}-uvloop \
    ${PYTHON_PN}-python-multipart \
    ${PYTHON_PN}-cryptography \
    ${PYTHON_PN}-packaging \
    fw-om \
    fw-pmb \
    u-boot-fw-utils \
    bash \
"

SYSTEMD_SERVICE_${PN} = "ttne-ota.service ttne-ota-health.service ttne-ota-health-boot.service"

do_install_append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/ttne

    install -d ${D}${libdir}/ttne
    install -m 755 ${S}/scripts/ota-boot-health.sh ${D}${libdir}/ttne/ota-boot-health.sh

    install -d ${D}${nonarch_base_libdir}/systemd/system
    install -m 644 ${WORKDIR}/ttne-ota.service ${D}${nonarch_base_libdir}/systemd/system/
    install -m 644 ${WORKDIR}/ttne-ota-health.service ${D}${nonarch_base_libdir}/systemd/system/
    install -m 644 ${WORKDIR}/ttne-ota-health-boot.service ${D}${nonarch_base_libdir}/systemd/system/

    install -d ${D}${datadir}/doc/ttne
    install -m 644 ${S}/docs/OTA.md ${D}${datadir}/doc/ttne/OTA.md
}

BBCLASSEXTEND = "native nativesdk"

INITSCRIPT_NAME = "ttne"
INITSCRIPT_PARAMS = "defaults 75"
