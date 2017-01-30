SERIAL_CONSOLE = "115200 ttymxc0"
SOC_FAMILY = "mx6:mx6sx"
DEFAULTTUNE_mx6sx ?= "cortexa9hf-neon"

KERNEL_IMAGETYPE = "uImage"

UBOOT_CONFIG[score] = "score_config"

IMAGE_FSTYPES += "tar.bz2"
#MKUBIFS_ARGS = " --min-io-size 4096 --leb-size 253952 --max-leb-cnt 1660"
#UBINIZE_ARGS = " --min-io-size 4096 --peb-size 262144 --sub-page-size 4096"
#MKUBIFS_ARGS = " --min-io-size 2048 --leb-size 126976 --max-leb-cnt 3925"
#UBINIZE_ARGS = " --min-io-size 2048 --peb-size 131072 --sub-page-size 4096"

# [   96.267406] UBI: scanning is finished
# [   96.271387] UBI: empty MTD device detected
# [   96.290089] UBI: attached mtd3 (name "rootfs", size 416 MiB) to ubi0
# [   96.296458] UBI: PEB size: 262144 bytes (256 KiB), LEB size: 253952 bytes
# [   96.303597] UBI: min./max. I/O unit sizes: 4096/4096, sub-page size 4096
# [   96.310507] UBI: VID header offset: 4096 (aligned 4096), data offset: 8192
# [   96.317390] UBI: good PEBs: 1660, bad PEBs: 4, corrupted PEBs: 0
# [   96.323651] UBI: user volume: 0, internal volumes: 1, max. volumes count: 128
# [   96.330951] UBI: max/mean erase counter: 0/0, WL threshold: 4096, image sequence number: 2423822396
# [   96.340151] UBI: available PEBs: 1620, total reserved PEBs: 40, PEBs reserved for bad PEB handling: 36
# [   96.349477] UBI: background thread "ubi_bgt0d" started, PID 667
# UBI device number 0, total 1660 LEBs (421560320 bytes, 402.0 MiB), available 1620 LEBs (411402240 bytes, 392.3 MiB), LEB size 253952 bytes (248.0 KiB)
