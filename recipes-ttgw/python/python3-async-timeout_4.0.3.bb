SUMMARY = "Timeout context manager for asyncio programs"
HOMEPAGE = "https://github.com/aio-libs/async-timeout"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc856ddcfba4b0b"

PYPI_PACKAGE = "async-timeout"

SRC_URI[sha256sum] = "4640d96be84d82d02ed59ea2b7105a0f7b33abe8703703cd0ab0bf87c427522f"

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"
