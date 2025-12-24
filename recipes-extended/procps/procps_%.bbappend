do_install_prepend () {

	echo "net/ipv6/conf/all/disable_ipv6=1" >> ${WORKDIR}/sysctl.conf

}
