# -*- mode: Conf; -*-
SUMMARY = "NE Django web server for PDUs"
HOMEPAGE = "https://bitbucket.org/tychetools/ne/"
LICENSE = "CLOSED"

SRCBRANCH = "main"
SRCREV = "1fc64c0fc972e818964a30847d2f0ae640fcb4f4"
SRC_URI = "git://bitbucket.org/tychetools/ne.git;protocol=ssh;branch=${SRCBRANCH}"

SRC_URI += " \
	file://env \
"


RDEPENDS_${PN} = "\
    python3-django\
    python3-dotenv\
    python3-djangorestframework\
    python3-requests\
    python3-djangorestframework-simplejwt\
"

FILES_${PN} = " \
    ${base_prefix}/opt/ne/* \
    ${base_prefix}/opt/ne/.env \
"

do_install() {
    install -d ${D}${base_prefix}/opt/ne
    cp -r ${WORKDIR}/git/*  ${D}${base_prefix}/opt/ne
    install -m 600 ${WORKDIR}/env ${D}${base_prefix}/opt/ne/.env

}
