FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

RDEPENDS_${PN} += "bash"

SRC_URI += " \
	file://ifup \
	file://ifdown \
"

do_install_append () {

	sed -i "/ifup/d" ${D}${sysconfdir}/busybox.links*
	sed -i "/ifdown/d" ${D}${sysconfdir}/busybox.links*

	install -d ${D}${base_sbindir}
	install -m 0755 ${WORKDIR}/ifup ${D}${base_sbindir}/ifup
	install -m 0755 ${WORKDIR}/ifdown ${D}${base_sbindir}/ifdown

}
