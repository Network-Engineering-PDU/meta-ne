SUMMARY = "Core Schema."
HOMEPAGE = "https://pypi.org/project/coreschema/"
AUTHOR = "Tom Christie"

LICENSE = "CLOSED"

PYPI_PACKAGE = "coreschema"

inherit pypi setuptools3

SRC_URI[sha256sum] = "9503506007d482ab0867ba14724b93c18a33b22b6d19fb419ef2d239dd4a1607"

RDEPENDS:${PN} += "python3-jinja2"

BBCLASSEXTEND = "native nativesdk"

