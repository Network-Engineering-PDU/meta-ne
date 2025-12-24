HOMEPAGE = "https://github.com/python/typing"
LICENSE = "PSF"
LIC_FILES_CHKSUM = "file://site-packages/typing_extensions-4.7.1.dist-info/LICENSE;md5=fcf6b249c2641540219a727f35d8d2c2"

SRC_URI += " \
	https://files.pythonhosted.org/packages/ec/6b/63cc3df74987c36fe26157ee12e09e8f9db4de771e0f3404263117e75b95/typing_extensions-4.7.1-py3-none-any.whl \
"

SRC_URI[sha256sum] = "440d5dd3af93b060174bf433bccd69b0babc3b15b1a8dca43789fd7f61514b36"

BBCLASSEXTEND = "native nativesdk"
inherit python3-dir

PROVIDES += "python3-typing-extensions"

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
    ${bindir}/env unzip ${S}/typing_extensions-4.7.1-py3-none-any.whl -d ${S}/site-packages
}

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages

    cp -r ${S}/site-packages/* ${D}${libdir}/${PYTHON_DIR}/site-packages/
}
