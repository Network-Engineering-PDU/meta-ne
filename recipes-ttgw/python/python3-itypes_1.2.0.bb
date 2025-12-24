SUMMARY = "Simple immutable types for python."
HOMEPAGE = "https://pypi.org/project/itypes/"
AUTHOR = "Tom Christie"

LICENSE = "CLOSED"

PYPI_PACKAGE = "itypes"

inherit pypi setuptools3

SRC_URI[sha256sum] = "af886f129dea4a2a1e3d36595a2d139589e4dd287f5cab0b40e799ee81570ff1"

RDEPENDS:${PN} += ""

BBCLASSEXTEND = "native nativesdk"

