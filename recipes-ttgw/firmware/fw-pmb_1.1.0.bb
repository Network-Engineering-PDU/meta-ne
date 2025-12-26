# -*- mode: Conf; -*-
SUMMARY = "NE power module base firmware binaries"
HOMEPAGE = "https://github.com/Network-Engineering-PDU/fw-pmb-pic/"
LICENSE = "CLOSED"

ZIP_FILE = "fw-pmb_1.1.0_pmb_boardv2.hex"
GIT_REPO = "fw-pmb-pic"

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
