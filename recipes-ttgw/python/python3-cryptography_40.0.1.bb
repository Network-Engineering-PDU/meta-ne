SUMMARY = "Provides cryptographic recipes and primitives"
DESCRIPTION = "cryptography is a package which provides cryptographic recipes and primitives to Python developers."
HOMEPAGE = "https://github.com/pyca/cryptography"
LICENSE = "Apache-2.0 | BSD"
LIC_FILES_CHKSUM = "file://site-packages/cryptography-40.0.1.dist-info/LICENSE;md5=bf405a8056a6647e7d077b0e7bc36aba"

DEPENDS += "openssl"
RDEPENDS:${PN} = "python3-cffi openssl"

WHL_FILE = "cryptography-40.0.1-cp38-cp38-linux_armv7l.whl"

SRC_URI = "https://github.com/Network-Engineering-PDU/cryptography-40.0.1/raw/main/${WHL_FILE};unpack=0"
SRC_URI[sha256sum] = "0514c1ea7730ae9fbaf35f2ec57c7e69d6d500e139faa6390e16821d08767688"

BBCLASSEXTEND = "native nativesdk"
inherit python3-dir

PROVIDES += "python3-cryptography"

do_unpack[depends] += "unzip-native:do_populate_sysroot"

S = "${WORKDIR}"

FILES_${PN} += "\
	${libdir}/${PYTHON_DIR}/site-packages/* \
"

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
