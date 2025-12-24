DESCRIPTION = "ReactiveX (Rx) for Python"
HOMEPAGE = "https://reactivex.io/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=81f64d8152017ecfec10b583e282e48f"

SRC_URI[sha256sum] = "e912e6591022ab9176df8348a653fe8c8fa7a301f26f9931c9d8c78a650e04e8"

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"

#DEPENDS += "${PYTHON_PN}-setuptools-native"
RDEPENDS:${PN} = "\
	${PYTHON_PN}-typing-extensions \
"
