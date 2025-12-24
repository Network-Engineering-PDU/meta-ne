# -*- mode: Conf; -*-
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://cm.crt \
    file://cm.key \
"

do_install_append () {

    install -d ${D}${sysconfdir}/nginx/default_certs
    install -m 0600 ${WORKDIR}/cm.crt ${D}${sysconfdir}/nginx/default_certs/cm.crt
    install -m 0600 ${WORKDIR}/cm.key ${D}${sysconfdir}/nginx/default_certs/cm.key

}
