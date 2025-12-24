FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

do_install_append () {
	install -m 644 ${D}${sysconfdir}/ssh/sshd_config ${D}${sysconfdir}/ssh/sshd_config_readonly
}
