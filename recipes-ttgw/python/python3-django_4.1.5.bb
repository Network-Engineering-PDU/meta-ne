DESCRIPTION = "A high-level Python web framework that encourages rapid development and clean, pragmatic design."
HOMEPAGE = "https://pypi.org/project/Django/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://site-packages/Django-4.1.5.dist-info/LICENSE;md5=f09eb47206614a4954c51db8a94840fa"

SRC_URI += " \
https://files.pythonhosted.org/packages/2d/ac/9f013a51e6008ba94a282c15778a3ea51a0953f6711a77f9baa471fd1b1d/Django-4.1.5-py3-none-any.whl \
"

SRC_URI[sha256sum] = "4b214a05fe4c99476e99e2445c8b978c8369c18d4dea8e22ec412862715ad763"

BBCLASSEXTEND = "native nativesdk"
inherit python3-dir

PROVIDES += "python3-django"

do_unpack[depends] += "unzip-native:do_populate_sysroot"

DEPENDS += ""
RDEPENDS:${PN} = "\
	python3-asgiref\
	python3-backports.zoneinfo\
	python3-sqlparse\
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
    ${bindir}/env unzip ${S}/Django-4.1.5-py3-none-any.whl -d ${S}/site-packages
}

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages

    cp -r ${S}/site-packages/* ${D}${libdir}/${PYTHON_DIR}/site-packages/
}
