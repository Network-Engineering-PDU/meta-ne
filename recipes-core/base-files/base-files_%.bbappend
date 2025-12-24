FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

hostname := "${HOSTNAME_Y}"

do_install_append() {

	sed -i '$d' ${D}${sysconfdir}/issue
	sed -i '$d' ${D}${sysconfdir}/issue
	echo "${MACHINE} FW ${GITREV} ${BOARD} \\\n \\\l" >> ${D}${sysconfdir}/issue
	echo "" >> ${D}${sysconfdir}/issue
	echo "BOARD=${BOARD}" > ${D}${sysconfdir}/ttversion
	echo "GITREV=${GITREV}" >> ${D}${sysconfdir}/ttversion
	echo "MACHINE=${MACHINE}" >> ${D}${sysconfdir}/ttversion

	echo "151.101.129.91 nmcheck.gnome.org" >> ${D}${sysconfdir}/hosts
}
