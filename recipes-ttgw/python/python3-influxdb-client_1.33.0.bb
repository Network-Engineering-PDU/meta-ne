DESCRIPTION = "InfluxDB 2.0 Python client library"
HOMEPAGE = "https://github.com/influxdata/influxdb-client-python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db58f42f79e83cae5947e215e55bb1db"

SRC_URI[sha256sum] = "45f6a1763804a19b972890daf4c5f0bd2d3ae2f202b86451c579e09dcadd30e6"
PYPI_PACKAGE = "influxdb_client"

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"

#DEPENDS += "${PYTHON_PN}-setuptools-native"
RDEPENDS:${PN} = "\
	${PYTHON_PN}-reactivex \
	${PYTHON_PN}-certifi\
	${PYTHON_PN}-dateutil \
	${PYTHON_PN}-setuptools \
	${PYTHON_PN}-urllib3 \
"
