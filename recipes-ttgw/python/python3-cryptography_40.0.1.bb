DESCRIPTION = "Cryptography library with OpenSSL bindings for ARMv7l"
HOMEPAGE = "https://github.com/Network-Engineering-PDU/cryptography-40.0.1"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://site-packages/cryptography-40.0.1.dist-info/LICENSE;md5=bf405a8056a6647e7d077b0e7bc36aba"

WHL_FILE = "cryptography-40.0.1-cp38-cp38-linux_armv7l.whl"

SRC_URI = "https://github.com/Network-Engineering-PDU/cryptography-40.0.1/raw/main/${WHL_FILE};unpack=0"

SRC_URI[sha256sum] = "0019dfc4b32d63c1392aa264aed2253c1e0c2fb09216f8e2cc269bbfb8bb49b5"

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

do_unpack() {
    rm -rf ${S}/site-packages
    mkdir -p ${S}/site-packages
    unzip -q ${S}/${WHL_FILE} -d ${S}/site-packages
}

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages
    cp -r ${S}/site-packages/* ${D}${libdir}/${PYTHON_DIR}/site-packages/
}
