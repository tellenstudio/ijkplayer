## Android版本编译说明

### 下载代码
	git clone https://github.com/tellenstudio/ijkplayer.git ijkplayer-android
	cd ijkplayer-android

### 编译develop分支
	git fetch origin
	git checkout -f develop
	git pull origin develop
	git checkout -B latest develop

### 配置ndk路径
	export ANDROID_NDK=/path/android-ndk-r13b

#### 下载相关依赖库
	./init-android.sh

### 编译ffmpeg(支持cronet版本)
	cd android/contrib
	./compile-ffmpeg-cronet.sh clean
	./compile-ffmpeg-cronet.sh armv7a|arm64

### 编译ijkplayer
	cd ..
	./compile-ijk.sh armv7a|arm64

### 输出目录
	
	# armv7
	ijkplayer-android/android/contrib/build/ffmpeg-armv7a/output
	ijkplayer-android/android/ijkplayer/ijkplayer-armv7a/src/main/libs/armeabi-v7a

	# arm64
	ijkplayer-android/android/contrib/build/ffmpeg-arm64/output
	ijkplayer-android/android/ijkplayer/ijkplayer-arm64/src/main/libs/arm64-v8a


### 依赖仓库目录
[FFmpeg](https://github.com/tellenstudio/FFmpeg)

[libyuv](https://github.com/tellenstudio/libyuv)

[soundtouch](https://github.com/tellenstudio/soundtouch)
