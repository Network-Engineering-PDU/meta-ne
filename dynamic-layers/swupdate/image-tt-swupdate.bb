DESCRIPTION = "Tychetools image that contains features to enable swupdate"
LICENSE = "CLOSED"

require recipes-fsl/images/image-tt.bb

CORE_IMAGE_EXTRA_INSTALL += " \
	swupdate \
	swupdate-www \
	kernel-image \
	kernel-devicetree \
"

IMAGE_FSTYPES = "tar.gz"
