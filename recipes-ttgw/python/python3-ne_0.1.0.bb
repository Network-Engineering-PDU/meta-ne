# -*- mode: Conf; -*-
SUMMARY = "NE Django web server for PDUs"
HOMEPAGE = "https://github.com/Network-Engineering-PDU/ne/"
LICENSE = "CLOSED"

SRCBRANCH = "main"
SRCREV = "7b8930a66d03b40b4a5a7e2cb4e3c9ca8b156be2"
SRC_URI = "git://github.com/Network-Engineering-PDU/ne.git;protocol=https;branch=${SRCBRANCH}"

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
