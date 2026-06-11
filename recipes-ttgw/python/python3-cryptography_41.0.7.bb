SUMMARY = "Provides cryptographic recipes and primitives"
DESCRIPTION = "cryptography is a package which provides cryptographic recipes and primitives to Python developers."
HOMEPAGE = "https://github.com/pyca/cryptography"
LICENSE = "Apache-2.0 | BSD"
LIC_FILES_CHKSUM = "file://site-packages/cryptography-41.0.7.dist-info/LICENSE;md5=8c3617db4fb6fae01f1d253ab91511e4"

DEPENDS += "openssl"
RDEPENDS:${PN} = "python3-cffi openssl"

WHL_FILE = "cryptography-41.0.7-cp38-cp38-linux_armv7l.whl"

SRC_URI = "https://dl.espressif.com/pypi/cryptography/${WHL_FILE};unpack=0"
SRC_URI[sha256sum] = "6bb0e940a5cfc4baeb61325327af832ffd47feaec2e5c3cbd619491fd9061e26"

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
