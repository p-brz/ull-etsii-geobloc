# Introduction #

We needed a class to separate the Activity handling the form presentation and user input from the code to save files to the SD Card. This is the duty of **GeoBlocPackageManager**.


# Details #

First, and foremost, note that there are two constructors, one without parameters and one with one parameter; the latter one creates a directory. Since this class is useful both for making packages and for reading them, you do not always want to use the second constructor. Also, note that it is recommended to get storage paths from SharedPreferences.

**Reading a package/Directory**:

Necessary methods:

```
public GeoBlocPackageManager();
```

This constructor does not write any contents to the SD Card, it only initializes its intenral state.

```
public boolean isOK();
```

This method tells us if the instance is ready to read/write files. It might not be ready, for example, if there is no bulk storage in the device.

```
public boolean openPackage(String fullpath)
public boolean openOrBuildPackage(String fullpath)
```

These two methods do the same, but the second one with a bonus. They associate the GeoBlocPackageManager instance to a directory in the SDCard. In this way, you can access directories full of files through this class, instead of doing it directly. The second method opens if the directory exists, and creates it if it doesn't. It is recommended to call the isOK method immediately to check if the directory was opened/created. If it returns false, all operations will fail.

```
 public List<String> getAllFilenames();
```
This method provides you with a list of all filenames in the current directory. Works the same if you're creating a package/directory or reading one.

```
public List<byte[]> getAllByteFiles();
public List<File> getAllFiles();
```

Both methods return the actual files in the current directory. This class was not designed to alter or delete files in a directory, only to store files and read them.

**NOTE:** the getPackageFullPath() is important, since you can use it to get either the full path of a package you've just built or of one you've opened. The directory returned by this method can be used as input for the openPackage(...) and openOrBuild(...) methods. It was actually designed for this.

**Building a Package**

```
public GeoBlocPackageManager(String packageName);
```

As its name implies, you use this to create a package and associate it to the instance. Notice that the full path is not required, since it uses the path from SharedPreferences for packages, only the package name. It is highly recommended to check with the isOK() method beofre performing any other operations.

```
public boolean addFile(fileName, text);
public boolean addFile(fileName, data);
```

These two methods allow you to add a file to the package/directory through this class. You can either add a text file with the first method, or any kind of file using a byte array (byte[.md](.md)). Of course, files added will immediately show up if you perform a getAllFiles() or similar call.

**NOTE:** It is also possible to open a package/directory and add files.

```
 /* Example */
// initialization
// packageName is simply the package's name, do not worry about the full path
GeoBlocFormPackage formPackage = new GeoBlocPackageManager(getApplicationContext(), packageName);

// add files
formPackage.addFile("manifest.xml", text);

formPackage.addFile("image.jpeg", data);

// get files
List<File> files = formPackage.getAllFiles();
```

**Opening an existing package/directory**

Using both open methods, you can also use existing directories, and create them if they don't if you need to. Here's how:

```
/* Example */
// initialization
GeoBlocFormPackage formPackage = new GeoBlocPackageManager();

// if we want to simply open
formPackage.openPackage(fullpath);
// or if we want to open and create if it doesn't exist
formPackage.openOrBuildPackage(fullpath)

// fullpath meaning something like /sdcard/GeoBloc/packages/myNewPackage/

// add files
formPackage.addFile("manifest.xml", text);

formPackage.addFile("image.jpeg", data);

// get files
List<File> files = formPackage.getAllFiles();
```

**NOTE**: To aid you in building the fullpath when using both methods for opening packages, use the system preferences to get the standard path; this way you'd only need to add your package's name.

**FINAL NOTE**: Class name is subject to change since it does not fully reflect the class' functionality.