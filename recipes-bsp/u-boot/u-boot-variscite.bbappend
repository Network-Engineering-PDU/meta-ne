FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " file://uEnv.txt"
SRC_URI_append = " file://enable_importenv.patch"

UBOOT_ENV = "uEnv"
UBOOT_ENV_SUFFIX = "txt"

do_configure_append() {

    cp ${WORKDIR}/uEnv.txt ${S}

}

FILES_${PN}-env += " \
	/boot/uEnv.txt \
	"
