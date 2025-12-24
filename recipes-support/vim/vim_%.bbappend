
do_install_append () {
	echo 'set nobackup writebackup' >> ${D}/${datadir}/${BPN}/vimrc
	echo 'set noundofile' >> ${D}/${datadir}/${BPN}/vimrc
}
