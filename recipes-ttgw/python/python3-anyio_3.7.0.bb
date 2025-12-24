DESCRIPTION = "High level compatibility layer for multiple asynchronous event loop implementations"
HOMEPAGE = "https://pypi.org/project/anyio/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://site-packages/anyio-3.7.0.dist-info/LICENSE;md5=c0a769411d2af7894099e8ff75058c9f"

SRC_URI += " \
	https://files.pythonhosted.org/packages/68/fe/7ce1926952c8a403b35029e194555558514b365ad77d75125f521a2bec62/anyio-3.7.0-py3-none-any.whl \
"

SRC_URI[sha256sum] = "eddca883c4175f14df8aedce21054bfca3adb70ffe76a9f607aef9d7fa2ea7f0"

BBCLASSEXTEND = "native nativesdk"
inherit python3-dir

PROVIDES += "python3-anyio"

do_unpack[depends] += "unzip-native:do_populate_sysroot"

DEPENDS += ""
RDEPENDS:${PN} = "\
	python3-exceptiongroup\
	python3-idna\
	python3-sniffio\
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
    ${bindir}/env unzip ${S}/anyio-3.7.0-py3-none-any.whl -d ${S}/site-packages
}

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages

    cp -r ${S}/site-packages/* ${D}${libdir}/${PYTHON_DIR}/site-packages/
}
