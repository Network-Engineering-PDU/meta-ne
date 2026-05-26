DESCRIPTION = "Cryptography library with OpenSSL bindings for ARMv7l"
HOMEPAGE = "https://github.com/Network-Engineering-PDU/cryptography-40.0.1"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://site-packages/cryptography-40.0.1.dist-info/LICENSE.BSD;md5=5ae30ba4123bc4f2fa49aa0b0dce887b"

WHL_FILE = "cryptography-40.0.1-cp38-cp38-linux_armv7l.whl"
GIT_REPO = "Network-Engineering-PDU/cryptography-40.0.1"

SRC_URI = "https://github.com/${GIT_REPO}/releases/download/v40.0.1/${WHL_FILE};unpack=0"

SRC_URI[sha256sum] = "0514c1ea7730ae9fbaf35f2ec57c7e69d6d500e139faa6390e16821d08767688"

BBCLASSEXTEND = "native nativesdk"
inherit python3-dir

PROVIDES += "python3-cryptography"

do_unpack[depends] += "unzip-native:do_populate_sysroot"

DEPENDS += " openssl"
RDEPENDS:${PN} = "\
	python3-cffi\
	openssl\
"

S = "${WORKDIR}"

FILES_${PN} += "\
	${libdir}/${PYTHON_DIR}/site-packages/* \
"

do_fetch() {
	curl -O -L -P ${DL_DIR} "https://github.com/${GIT_REPO}/releases/download/v40.0.1/${WHL_FILE}"
}

do_unpack_append(){
    bb.build.exec_func('unpack_whl', d)
}

unpack_whl() {
    rm -rf ${S}/site-packages
    mkdir ${S}/site-packages
    ${bindir}/env unzip ${S}/${WHL_FILE} -d ${S}/site-packages
}

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages

    cp -r ${S}/site-packages/* ${D}${libdir}/${PYTHON_DIR}/site-packages/
}
