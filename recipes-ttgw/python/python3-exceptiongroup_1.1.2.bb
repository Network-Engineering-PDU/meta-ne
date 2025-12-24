DESCRIPTION = "Backport of PEP 654 (exception groups)"
HOMEPAGE = "https://pypi.org/project/exceptiongroup/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://site-packages/exceptiongroup-1.1.2.dist-info/LICENSE;md5=d5caa317463c433575efff1d2fe206d7"

SRC_URI += " \
	https://files.pythonhosted.org/packages/fe/17/f43b7c9ccf399d72038042ee72785c305f6c6fdc6231942f8ab99d995742/exceptiongroup-1.1.2-py3-none-any.whl \
"

SRC_URI[sha256sum] = "e346e69d186172ca7cf029c8c1d16235aa0e04035e5750b4b95039e65204328f"

BBCLASSEXTEND = "native nativesdk"
inherit python3-dir

PROVIDES += "python3-exceptiongroup"

do_unpack[depends] += "unzip-native:do_populate_sysroot"

DEPENDS += ""
RDEPENDS:${PN} = "\
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
    ${bindir}/env unzip ${S}/exceptiongroup-1.1.2-py3-none-any.whl -d ${S}/site-packages
}

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages

    cp -r ${S}/site-packages/* ${D}${libdir}/${PYTHON_DIR}/site-packages/
}
