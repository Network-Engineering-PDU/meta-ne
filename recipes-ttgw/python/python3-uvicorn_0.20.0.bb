DESCRIPTION = "The lightning-fast ASGI server"
HOMEPAGE = "https://pypi.org/project/uvicorn/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://site-packages/uvicorn-0.20.0.dist-info/licenses/LICENSE.md;md5=5c778842f66a649636561c423c0eec2e"

SRC_URI = " \
	https://files.pythonhosted.org/packages/96/f3/f39ac8ac3bdf356b4934b8f7e56173e96681f67ef0cd92bd33a5059fae9e/uvicorn-0.20.0-py3-none-any.whl \
	file://uvicorn.py \
"

SRC_URI[sha256sum] = "c3ed1598a5668208723f2bb49336f4509424ad198d6ab2615b7783db58d919fd"

BBCLASSEXTEND = "native nativesdk"
inherit python3-dir

PROVIDES += "python3-uvicorn"

do_unpack[depends] += "unzip-native:do_populate_sysroot"

RDEPENDS:${PN} = "\
	${PYTHON_PN}-core\
	${PYTHON_PN}-uvloop\
	${PYTHON_PN}-click\
	${PYTHON_PN}-h11\
	${PYTHON_PN}-httptools\
	${PYTHON_PN}-dotenv\
	${PYTHON_PN}-pyyaml\
	${PYTHON_PN}-watchfiles\
"

S = "${WORKDIR}"

FILES_${PN} += "\
    ${libdir}/${PYTHON_DIR}/site-packages/* \
	${bindir}/uvicorn \
"

do_unpack_append(){
    bb.build.exec_func('unpack_whl', d)
}

unpack_whl() {
    rm -rf ${S}/site-packages
    mkdir ${S}/site-packages
    ${bindir}/env unzip ${S}/uvicorn-0.20.0-py3-none-any.whl -d ${S}/site-packages
}

do_install() {
	install -d ${D}${bindir}
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages

    cp -r ${S}/site-packages/* ${D}${libdir}/${PYTHON_DIR}/site-packages/
	install -m 755 ${S}/uvicorn.py ${D}${bindir}/uvicorn

}
