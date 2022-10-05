### Layout from code (quick replacement for RecyclerView)

#### layout.xml
```
    <androidx.constraintlayout.widget.ConstraintLayout
        android:id="@+id/devices_list_layout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        app:layout_constraintTop_toBottomOf="@+id/premiseDevicesTextView"
        android:layout_marginTop="@dimen/activity_vertical_margin"
        android:layout_marginHorizontal="@dimen/horizontal_margin_large">

    </androidx.constraintlayout.widget.ConstraintLayout>
```

#### kotlin
```
...
    // onViewCreated
    binding.devicesListLayout.viewTreeObserver.addOnGlobalLayoutListener(object :
                ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    binding.devicesListLayout.viewTreeObserver.removeOnGlobalLayoutListener(this)
                    val width: Int = binding.devicesListLayout.width

                    // TODO: use device list from repo
                    val devices = arrayListOf(
                        "Label 1",
                        "Label 2",
                        "Label 3",
                        "Label 4"
                    )
                    renderPremiseDevices(width, devices)
                }
            })

...

    private fun renderPremiseDevices(parentWidth: Int, devices: List<String>) {
        binding.devicesListLayout.removeAllViews()

        val flow = Flow(context).apply {
            id = generateViewId()
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            setWrapMode(Flow.WRAP_CHAIN)
            setHorizontalStyle(Flow.CHAIN_SPREAD_INSIDE)
            setHorizontalAlign(Flow.HORIZONTAL_ALIGN_START)
            setHorizontalBias(0f)
            setOrientation(Flow.HORIZONTAL)
        }
        binding.devicesListLayout.addView(flow)

        val referenceIds = IntArray(devices.size)
        context?.let {
            devices.forEachIndexed { index, device ->
                val textView = SpTextView(it).apply {
                    id = generateViewId()
                    layoutParams = LayoutParams(parentWidth / 2, LayoutParams.WRAP_CONTENT)
                    referenceIds[index] = id
                    setTextSize(
                        TypedValue.COMPLEX_UNIT_PX,
                        resources.getDimension(R.dimen.text_size_h6)
                    )
                    setTextColor(ContextCompat.getColor(requireContext(), R.color.gunmetal))
                    text = device
                }
                binding.devicesListLayout.addView(textView)
            }
        }
        flow.referencedIds = referenceIds
    }
```
