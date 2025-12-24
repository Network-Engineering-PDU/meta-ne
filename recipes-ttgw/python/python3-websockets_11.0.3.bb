SUMMARY = "An implementation of the WebSocket Protocol (RFC 6455)"
HOMEPAGE = "https://github.com/aaugustin/websockets"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://site-packages/websockets-11.0.3.dist-info/LICENSE;md5=51924a6af4495b8cfaee1b1da869b6f4"


SRC_URI += " \
	https://files.pythonhosted.org/packages/47/96/9d5749106ff57629b54360664ae7eb9afd8302fad1680ead385383e33746/websockets-11.0.3-py3-none-any.whl \
"

SRC_URI[sha256sum] = "6681ba9e7f8f3b19440921e99efbb40fc89f26cd71bf539e45d8c8a25c976dc6"

BBCLASSEXTEND = "native nativesdk"
inherit python3-dir

PROVIDES += "python3-websockets"

do_unpack[depends] += "unzip-native:do_populate_sysroot"

DEPENDS += ""
RDEPENDS:${PN} = "\
    ${PYTHON_PN}-asyncio \
"

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
    ${bindir}/env unzip ${S}/websockets-11.0.3-py3-none-any.whl -d ${S}/site-packages
}

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages

    cp -r ${S}/site-packages/* ${D}${libdir}/${PYTHON_DIR}/site-packages/
}
