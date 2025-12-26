# -*- mode: Conf; -*-
SUMMARY = "NE outlet module firmware binaries"
HOMEPAGE = "https://github.com/Network-Engineering-PDU/fw-om-avr/"
LICENSE = "CLOSED"

ZIP_FILE = "fw-om_1.7.0_om_boardv1.hex"
GIT_REPO = "fw-om-avr"

SRC_URI = "https://github.com/Network-Engineering-PDU/${GIT_REPO}/raw/main/${ZIP_FILE};unpack=0"

S = "${WORKDIR}"

do_fetch() {
	curl -L -o ${DL_DIR}/${ZIP_FILE} "https://github.com/Network-Engineering-PDU/${GIT_REPO}/raw/main/${ZIP_FILE}"
}

do_install() {
	install -d ${D}${base_prefix}/opt/${PN}
	install -m 0644 ${ZIP_FILE} ${D}${base_prefix}/opt/${PN}
}

FILES_${PN} = " \
	${base_prefix}/opt/${PN}/* \
"

PACKAGES = "${PN}"
